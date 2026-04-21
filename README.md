# ⚡ VoltStream Engine
> **Spring Boot 기반 전기차 충전소 실시간 요금 산출 시뮬레이션 시스템**

본 프로젝트는 지역별 전기차 충전소의 전력 사용량 데이터를 기반으로, 실시간 수요에 따른 **권장 충전 요금 지수(Billing Index)를 산출**하고 관리하는 백엔드 서비스입니다. 외부 의존성 없이 독립적으로 구동되는 자동화된 데이터 파이프라인 구축에 초점을 맞추었습니다.

---

## 🏗️ System Architecture & Data Flow

시스템은 가상의 전력 데이터가 생성되어 최종 요금 지표로 가공되기까지의 전체 라이프사이클을 관리합니다.

1. **Data Generation**: `UsageGenerator`가 15분마다 각 충전소의 가상 전력 사용량(kWh)을 무작위로 생성합니다.
2. **Scheduling**: `Spring Scheduling`이 주기적으로 생성된 데이터를 수집하여 요금 계산 로직을 트리거합니다.
3. **Processing**: 수집된 전력량과 충전소별 가중치를 바탕으로 '지역별 권장 요금 지수'를 산출합니다.
4. **Storage & API**: 계산된 지수를 DB에 영속화하고, 사용자가 Querydsl을 통해 다각도로 조회할 수 있는 API를 제공합니다.

---

## ✨ Key Features (핵심 기능)

- **Real-time Billing Simulation**: 전력 수요(Usage) 변화에 따른 유동적인 요금 지수 산출 로직 구현.
- **Automated Pipeline**: `@Scheduled`를 활용한 15분 단위 자동 데이터 수집 및 갱신 시스템.
- **Advanced Search & Filtering**: **Querydsl**을 사용하여 충전소명, 운영사, 지역, 충전기 타입(급속/완속) 등 다중 조건 필터링 지원.
- **Precision Calculation**: 데이터 정밀도를 보장하기 위해 `double` 대신 **`BigDecimal`**을 활용한 수치 연산 적용.

---

## 🛠️ Tech Stack (기술 스택)

- **Language**: Java 17
- **Framework**: Spring Boot 3.x
- **Database**: JPA (Hibernate), H2 (In-memory)
- **Query**: Querydsl 5.0
- **Build**: Gradle 8.x

---

## 🚀 Technical Challenges & Solutions (기술적 도전)

#### 1. 독립적 시뮬레이션 환경 구축
외부 API 서버의 가용성이나 인증 토큰 만료와 관계없이 시스템의 무결성을 검증할 수 있도록 내부 가상 데이터 공급(Mocking) 구조를 설계했습니다. 이를 통해 로컬 환경에서도 전체 비즈니스 로직을 완벽하게 테스트할 수 있습니다.

#### 2. 시계열 데이터(Time-series) 히스토리 관리
단순히 현재 요금을 업데이트하는 것에 그치지 않고, 시간대별 요금 변화를 추적할 수 있도록 시계열 데이터 구조로 설계하였습니다. 이는 추후 통계 분석 및 대시보드 확장성을 고려한 설계입니다.

#### 3. 관심사의 분리 (SoC)
데이터 생성(Generator), 요금 산출(Service), 스케줄링 트리거(Scheduler)의 역할을 명확히 분리하여 코드의 유지보수성과 가독성을 높였습니다.

---

## ⚙️ How to Run (실행 방법)

```bash
# 1. 프로젝트 복제
git clone [https://github.com/your-username/springboot-volt-stream-engine.git](https://github.com/your-username/springboot-volt-stream-engine.git)

# 2. 어플리케이션 실행 (로컬 프로필로 실행 시 15분마다 데이터 자동 생성)
./gradlew bootRun
