#  課程實作練習筆記(springboot-mall)
 **根據課程教學的步驟一步一步打造簡易的功能**
 
 使用工具：IntelliJ IDEA、MySQL Server、API Tester


---

## 商品功能
### 1. 查詢/新增/修改/刪除商品
設計API實作CRUD功能。

|HTTP method|對應資料庫操作| 備註 |
| -------- | ----------- | -------- |
| Post     | Create (新增)| 新增資源  |
| Get      | Read   (查詢)| 取得資源  |
| Put      | Update (修改)| 更新資源  |
| Delete   | Delete (刪除)| 刪除資源  |


---


### 2. 查詢商品列表(查詢條件/排序/分頁)
**1. 實作查詢商品篩選(根據種類/關鍵字搜尋 篩選出顧客所需要的商品)。**
註：使用SQL的LIKE語法。

**2. 實作商品排序(根據查詢條件進行升序或是降序排序)。**
註：使用SQL的ORDER BY、DESC/ASC語法。

**3. 實作商品分頁功能(於每一頁顯示固定數量)。**
註：使用SQL的LIMIT、OFFSET語法。

* 實作要點：撰寫SQL指令時可以透過WHERE 1=1 來拼接語法。
```java=
String sql = "SELECT * FROM product WHERE 1=1";

sql = sql + " AND category = FOOD AND product_name LIKE %蘋果% ORDER BY price";
```

---
## 使用者功能
### 註冊 / 登入功能
#### **為確保資訊安全，實作要點：**
**1. 避免將隱私資訊放入網址，因此使用 Request Body 傳遞參數**
(註冊/登入功能 皆透過 Post 方法請求參數)。

**2. 密碼不應該以明碼的方式顯示在資料庫。**
(使用 MD5 生成密碼的雜湊值後放入資料庫)

```java=
String hashedPassword = DigestUtils.md5DigestAsHex(userLoginRequest.getPassword().getBytes());
```

**3. 回傳的User物件中不應包含密碼的資訊，因此使用 @JsonIgnore 來隱藏User物件中的Password。**
```java=
    private Integer userId;
    private String email;
    @JsonIgnore
    private String password;
    private Date createdDate;
    private Date lastModifiedDate;
```







