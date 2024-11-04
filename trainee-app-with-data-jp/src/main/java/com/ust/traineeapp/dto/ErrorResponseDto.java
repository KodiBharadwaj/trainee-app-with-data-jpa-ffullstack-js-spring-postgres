package com.ust.traineeapp.dto;

import java.time.LocalDateTime;


public record ErrorResponseDto(LocalDateTime timestamp,
                               int status,
                               String error,
                               String message,
                               String path){ }
