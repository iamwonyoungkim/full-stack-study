package org.scoula.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
// 채팅 문자열 메시지
public class ChatMessage {
    private String name;
    private String content;
}
