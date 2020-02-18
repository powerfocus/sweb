package org.py.sweb.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class Upfiles implements Serializable {
    private static final long serialVersionUID = -1899856651542888631L;
    @Id
    private Long id;
    private String title;
    private String author;
    private String filetype;
    private String extName;
    private LocalDateTime uploadDatetime;
    private byte[] content;
}
