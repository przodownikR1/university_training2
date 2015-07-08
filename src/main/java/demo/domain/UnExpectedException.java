package demo.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.Data;

@Entity
@XmlRootElement
@Data
public class UnExpectedException extends AbstactId {
    private static final long serialVersionUID = 8284569238600218725L;
    protected static final String TABLE_NAME = "UNEXPECTED_EXCEPTION";

    @NotNull
    @Lob
    @Column(name = "EXCEPTION", nullable = false)
    private String exception;

    @Lob
    @Column(name = "MESSAGE")
    private String message;

    @Lob
    @Column(name = "DESCRIPTION")
    private String description;

    @NotNull
    @Column(name = "ERROR_NUMBER", nullable = false, length = 128)
    private String errorNumber;

    @NotNull
    @Column(name = "FUNCTION_NAME", nullable = false, length = 128)
    private String functionName;

    @NotNull
    @Column(name = "FORM_OR_MODULE_NAME", nullable = false, length = 128)
    private String formOrModuleName;
    public static final String FORM_OR_MODULE_NAME_FIELD_NAME = "formOrModuleName";

    @Column(name = "ARGUMENTS", length = 256)
    private String arguments;
    public static final String ARGUMENTS_FIELD_NAME = "arguments";

    public UnExpectedException(String exception, String message, String description, String errorNumber, String functionName, String formOrModuleName) {
        this.errorNumber = errorNumber;
        this.functionName = functionName;
        this.formOrModuleName = formOrModuleName;
    }

    public UnExpectedException() {
        super();
    }

}