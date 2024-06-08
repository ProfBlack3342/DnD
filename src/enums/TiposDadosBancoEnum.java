/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package enums;

/**
 *
 * @author dudup
 */
public enum TiposDadosBancoEnum {
    DATE("java.sql.Date"),
    DATETIME(""),
    TIMESTAMP("java.sql.Timestamp"),
    TIME("java.sql.Time"),
    YEAR(""),
    
    BIT("java.lang.Boolean"),
    TINYINT("java.lang.Boolean"),
    BOOL("java.lang.Boolean"),
    SMALLINT("java.lang.Short"),
    MEDIUMINT("java.lang.Integer"),
    INT("java.lang.Integer"),
    BIGINT("java.lang.Long"),
    FLOAT("java.lang.Float"),
    DOUBLE("java.lang.Double"),
    DECIMAL("java.math.BigDecimal"),
    
    CHAR("java.lang.String"),
    VARCHAR("java.lang.String"),
    BINARY("java.lang.Byte[]"),
    VARBINARY("java.lang.Byte[]"),
    TINYBLOB(""),
    TINYTEXT(""),
    TEXT("java.sql.Clob"),
    BLOB("java.sql.Blob"),
    MEDIUMTEXT(""),
    MEDIUMBLOB(""),
    LONGTEXT(""),
    LONGBLOB(""),
    ENUM("java.lang.String"),
    SET("java.lang.String[]");
    
    private final String tipoJava;

    private TiposDadosBancoEnum(String tipoJava) {
        this.tipoJava = tipoJava;
    }
    
    
}
