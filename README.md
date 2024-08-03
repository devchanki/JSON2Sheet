
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
