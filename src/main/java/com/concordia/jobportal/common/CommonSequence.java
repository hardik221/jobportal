package com.concordia.jobportal.common;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "common_sequence")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CommonSequence {
    @Id
    private String id;
    private long seq;
}
