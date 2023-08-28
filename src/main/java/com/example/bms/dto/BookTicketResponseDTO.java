package com.example.bms.dto;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class BookTicketResponseDTO {

    private ResponseStatus responseStatus;

    private String message;

    private long dummyTicketId;
}
