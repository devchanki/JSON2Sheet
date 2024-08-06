
# Overview
JSON 을 받아 엑셀 문서를 만드는 라이브러리
여러가지 형태로 JSON 을 받아, 엑셀로 만들어주는 라이브러리 입니다. 

# 사용법
### URL

``` JAVA
Json2Sheet json2Sheet = new Json2Sheet();
// URL, FilePath + FileName
json2Sheet.convertHttpResponseJsonToExcelToFilePath("https://jsonplaceholder.typicode.com/comments", "test.xlsx");
```
Result
![image](https://github.com/user-attachments/assets/ecaf973b-4d68-482b-b57a-d6951c152566)

### File 경로

``` JAVA
    Json2Sheet json2Sheet = new Json2Sheet();
    json2Sheet.convertJsonToExcelToFilePath("./test.json", "testWithFile.xlsx");
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

![image](https://github.com/user-attachments/assets/de1fabfa-e735-458b-bb0b-b32a67ba22da)

