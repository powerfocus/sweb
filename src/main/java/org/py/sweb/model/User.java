package org.py.sweb.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;
import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class User implements Serializable {
    private static final long serialVersionUID = -5946652237588600192L;
    @Id
    private Long id;
    private String username;
    private String pwd;
}
