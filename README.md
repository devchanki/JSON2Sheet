
# Overview
JSON 을 받아 엑셀 문서를 만드는 라이브러리
여러가지 형태로 JSON 을 받아, 엑셀로 만들어주는 라이브러리 입니다. 

# 사용법
### URL

``` JAVA
// URL, FilePath + FileName
    Json2Sheet json2Sheet = Json2Sheet.fromJSON(new URL("https://jsonplaceholder.typicode.com/comments"));
    json2Sheet.saveExcel("hello.xlsx");
```

[URL 내 데이터 미리보기](https://jsonplaceholder.typicode.com/comments)

Result
![image](https://github.com/user-attachments/assets/ba3d37dc-3259-49a0-9613-0fa4efdc27a3)


### File 경로

``` JAVA
    Json2Sheet json2Sheet1 = Json2Sheet.fromJSON("./test.json");
    json2Sheet1.saveExcel("hello1.xlsx");
```

test.json
``` JSON
[
  {
    "name": "John Doe",
    "age": 30
  },
  {
    "name": "Jane Smith",
    "age": 25
  },
  {
    "name": "Emily Johnson",
    "age": 35
  }
]
```
Result

![image](https://github.com/user-attachments/assets/c41c92bd-fab6-4f1b-9005-4fa7827c7898)


