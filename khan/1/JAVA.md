# JAVA 훑어보기
--------------
## 0. 목차
1. Intro
 - JAVA의 기본개념을 다룬다.
2. Basic JAVA API
 - JAVA의 기본 API들을 살펴본다.
3. Exception handling
 - 예외 처리에 대해 살펴본다.
4. Multi threading
 - 멀티스레딩에 대해 살펴본다.
5. I/O
 - 기본적인 입출력에 대해 살펴본다.
7. Network
 - JAVA에서 네트워크를 사용할수 있는 방법을 알아본다.
8. JDBC / Database
 - 데이터베이스를 다루는 기술을 다룬다.
9. Reflection
 - 리플렉션에 대해 살펴본다.
10. GUI
 - 대표적인 자바의 GUI 구현체를 살펴본다.
11. Web Service
 - 웹 서비스에 대해 살펴본다.

----------------------------------------------------------------------

## 1. Intro
##### JAVA의 기본개념에 대해 살펴본다.
 1. JAVA와 OOP 설명. JVM에 대해서도...

## 2. Basic JAVA API
##### JAVA의 자주 쓰는 기본 패키지들을 살펴본다.
 1. java.awt
  - 기본적인 GUI 구성을 위해 사용되는 패키지
  - 디자인적인 얘기 줄줄줄

 1. java.io / java.nio
  - 입출력에 관련된 패키지

 1. java.lang
  - JAVA 언어에서 가장 기본적인 클래스를 제공하는 패키지
  - import를 하지 않아도 쓸 수 있다.
          String, Object, Thread, Exception, etc.....

 1. java.net
  - 네트워크와 관련된 패키지.
  - 기본적인 소켓 통신과 HTTP 통신을 위한 기본 클래스들이 제공된다.

 1. java.security
  - 기본적인 보안에 관련된 패키지
  - 암호화 및 복호화 에 관련된 클래스들이 제공된다.

 1. java.util
  - 여러가지 유틸리티를 제공하는 패키지
  - 집합 클래스(Map, List, Set 등), Locale, 문자열 형식(Formatting) 등 여러 클래스 제공
    - 하위 클래스 : java.util.concurrent, java.util.regex, java.util.zip 등


이후 자바의 많은 패키지들을 소개한다.
javax로 시작되는 확장 클래스들에 대해....

## 3. Exception handling
##### 예외 처리에 대한 기본적인 설명
 1. try / catch / finally
 1. Exception 클래스에 대해 간략히
    1. Error
        - 대표적인 Error : StackOverflowError
    1. Exception 
        - RuntimeException
          - NullpointerException, IllegalArgumentException, IndexOutOfBoundsException
        - 그외 checked Exception
          - RuntimeException이 아닌 모든 Exception 하위 클래스
          - IOException, 커스텀 Exception 
    1. Throwable

## 4. Multi threading
 1. Thread에 대해 간단 설명
  - 공장 작업라인 블라블라~
 1. 멀티 스레드를 위해 자바에서 제공하는 것들을 설명한다.
  - Thread, Runnable
  - Executor / Callable / Future
  - 동시성 제어
        - synchronized, volatile 키워드 간단설명
  - java.concurrent 패키지

## 5. I/O
##### JAVA의 IO에 대해 설명
io에 관련된 설명 조금, nio에 대한 설명 조금
 1. io : InputStream, OutputStream 등
 1. nio : 탄생배경과 io와의 성능차이

## 6. Network
##### 네트워크에 대해 설명
 - Socket, URL등에 대해 설명
 - 라이브러리 몇 개 소개
    - Apache HttpClient --> Http 통신의 기본이라 생각됨
    - Netty, MINA --> 국산이다.
    - etc, ....

## 7. JDBC / Database
##### 데이터베이스 연결에 대한 설명
 - JDBC 개요 및 각 DriverClass, DB 관련 패키지 설명

## 8. Reflection
##### 리플렉션의 개요 및 필요성, 활용하는 곳에 대한 간략설명


## 9. GUI
##### GUI를 구현하기 위한 것들 설명


## 10. Web Service
##### 웹서비스를 하기 위한 프레임워크 변천사
 1. J2EE 스펙 간단설명 (간단하게...?;;;)
 1. EJB
 1. Struts
 1. Spring
 1. Play
 1. 기타등등

## Bonus. JAVA Evolution History
##### JAVA 버전의 진화 과정을 설명한다.
 1. JAVA 1.4 > 1.5(JDK 5)
  - 네이밍 변경
  - Generics 추가
  - foreach 추가
  - Enum 타입 추가
  - static import 추가
  - Annotation 추가
  - concurrent api 추가

 1. JAVA 5 > 6
  -
  
 1. JAVA 6 > 7
  -

 1. JAVA 7 > 8
  -
