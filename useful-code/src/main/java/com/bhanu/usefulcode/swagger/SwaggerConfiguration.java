package com.bhanu.usefulcode.swagger;

public class SwaggerConfiguration {
  @Bean
  @ConditionalOnProperty(name = "runtime.context.environment", havingValue = "PROD")
  public UiConfiguration submitMethodsDisabledForProd() {
    // for Prod env, we will not be able to trigger the functionality from Swagger.
    return UiConfigurationBuilder.builder().supportedSubmitMethods(new String[] {}).build();
  }
}
