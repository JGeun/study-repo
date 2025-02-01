### Kotlin Reflection을 이용한 Mapper 테스트 결과
DTO에 없는 프로퍼티가 VO에 있을 경우 NullPointerException 문제 발생.
혹은 VO에 이름은 같지만 다른 반환형일 경우 argument type mismatch 에러 발생

### 결론
기존에 다른 오픈소스에서 사용하는 것처럼 형식을 가져가는 것이 나을 것 같다.