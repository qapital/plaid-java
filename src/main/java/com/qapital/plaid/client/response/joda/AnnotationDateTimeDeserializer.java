package com.qapital.plaid.client.response.joda;

import com.fasterxml.jackson.datatype.joda.cfg.FormatConfig;
import com.fasterxml.jackson.datatype.joda.deser.DateTimeDeserializer;
import org.joda.time.DateTime;

/**
 *
 * Needed since the DateTimeDeserializer does ot have a default constructor to use with annotations
 * http://stackoverflow.com/questions/38433432/class-com-fasterxml-jackson-datatype-joda-deser-datetimedeserializer-has-no-defa
 *
 */
public class AnnotationDateTimeDeserializer extends DateTimeDeserializer {

    public AnnotationDateTimeDeserializer() {
        super(DateTime.class, FormatConfig.DEFAULT_DATETIME_PARSER);
    }
}
