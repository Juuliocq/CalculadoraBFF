BUILD:<br>
mvn clean package<br>

RODAR (NECESSÁRIO O JAVA 8)<br>
{CAMINHO_JAVA_8}/bin/java -Dcorba.service.url=corbaloc::{IP_NAMING_SERVICE}:2809/NameService -jar target/CalculadoraBFF-1.0.0.jar 