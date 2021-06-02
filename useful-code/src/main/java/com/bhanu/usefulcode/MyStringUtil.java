
import com.google.common.base.Splitter;


publiC class MyStringUtil {
    public static final String NAME_SPLIT_REGEX = "[^a-zA-Z0-9']+";
    public static final Splitter NAME_SPLITTER = Splitter.on(NAME_SPLIT_REGEX).omitEmptyStrings().trimResults();
}
