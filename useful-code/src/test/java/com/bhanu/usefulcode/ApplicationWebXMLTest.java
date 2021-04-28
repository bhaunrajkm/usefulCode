package com.bhanu.usefulcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.builder.SpringApplicationBuilder;

public class ApplicationWebXMLTest {
    private ApplicationWebXML applicationWebXML;

    @Mock
    private SpringApplicationBuilder springApplicationBuilder;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        applicationWebXML = new ApplicationWebXML();
    }

    @Test
    public void testConfigure() {
        //to mock static method
        try (MockedStatic<DefaultProfileUtil> defaultProfileUtilMockedStatic = Mockito.mockStatic(DefaultProfileUtil.class)) {
            defaultProfileUtilMockedStatic.when(() -> DefaultProfileUtil.addDefaultProfile(Mockito.any()))
                    //since addDefalut method is void method so on invocation we should not do any thing
                    .then(invocationOnMock -> null);

            Mockito.when(springApplicationBuilder.sources(Mockito.any()))
                    .thenReturn(springApplicationBuilder);

            Assertions.assertEquals(springApplicationBuilder, applicationWebXML.configure(springApplicationBuilder));
        }
    }
}