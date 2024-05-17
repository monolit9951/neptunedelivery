package com.neptunes.configuration;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.persistence.AttributeConverter;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@Component
@Slf4j
@RequiredArgsConstructor
public class HashMapConverter implements AttributeConverter<Map<Long, BigDecimal>, String> {

    private final ObjectMapper objectMapper;

    public HashMapConverter(){
        objectMapper = new ObjectMapper();
    }

    @Override
    public String convertToDatabaseColumn(Map<Long, BigDecimal> longBigDecimalMap) {
        String customInfoJson = null;
        try {
            customInfoJson = objectMapper.writeValueAsString(longBigDecimalMap);
        } catch (final JsonProcessingException e) {
            log.error("JSON writing error", e);
        }

        return customInfoJson;
    }

    @Override
    public Map<Long, BigDecimal> convertToEntityAttribute(String json) {
        Map<Long, BigDecimal> customInfo = null;
        try {
            customInfo = objectMapper.readValue(json, new TypeReference<HashMap<Long, BigDecimal>>() {});
        } catch (final IOException e) {
            log.error("JSON reading error", e);
        }

        return customInfo;
    }
}
