package org.scoula.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
// 입장 메시지
public class GreetingMessage {
    private String name;
}
