package one.digitalinnovation.persoalapi.utils;

import one.digitalinnovation.persoalapi.dto.request.PhoneDTO;
import one.digitalinnovation.persoalapi.entity.Phone;
import one.digitalinnovation.persoalapi.enums.PhoneType;

public class PhoneUtils {

    private static final String PHONE_NUMBER = "42999161446";
    private static final PhoneType PHONE_TYPE = PhoneType.MOBILE;
    private static final long PHONE_ID = 1L;

    public static PhoneDTO createFakeDTO() {
        return PhoneDTO.builder()
                .number(PHONE_NUMBER)
                .type(PHONE_TYPE)
                .build();

    }

    public static Phone createFakeEntity() {
        return Phone.builder()
                .id(PHONE_ID)
                .number(PHONE_NUMBER)
                .type(PHONE_TYPE)
                .build();
    }
}
