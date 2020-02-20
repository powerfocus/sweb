package org.py.sweb.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Resources implements Serializable {
    private static final long serialVersionUID = 2510969528974633964L;
    private Long id;
    private String resName;
    private String source;
    private Long belongId;
    private byte[] content;
}
