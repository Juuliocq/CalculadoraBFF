BUILD:
mvn clean package

RODAR (NECESSÁRIO JAVA 8)
RODAR BFF (JAVA 8)
{CAMINHO_JAVA_8}/bin/java -Dcorba.service.url=corbaloc::{IP_NAMING_SERVICE}:2809/NameService -jar target/CalculadoraBFF-1.0.0.jar 