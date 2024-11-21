package com.ms.user.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmailDTO {
    private UUID userId;
    private String emailTo;
    private String subject;
    private String text;
}

