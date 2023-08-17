#  課程實作練習筆記(springboot-mall)
 **根據課程教學的步驟一步一步打造簡易的電商網站功能**
 
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
Example:
```java=
String sql = "SELECT * FROM product WHERE 1=1";

sql = sql + " AND category = FOOD AND product_name LIKE %蘋果% ORDER BY price";
```







