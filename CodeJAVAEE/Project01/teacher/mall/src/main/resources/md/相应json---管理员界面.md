响应报文

#### login

```json
{"code":0,"data":{"token":"Test666666","name":"Test666666"}}
```

## 管理员界面

#### allAdmins

```json
{"code":0,"data":[{"id":1,"email":"123456789@qq.com","nickname":"admin","pwd":"HaHa123!"},{"id":29,"email":"1259835425@qq.com","nickname":"zl52335233","pwd":"Zl52335233!"},{"id":30,"email":"666666@qq.com","nickname":"Test666666","pwd":"Test666666!"},{"id":31,"email":"123415678@qq.com","nickname":"test5","pwd":"qwert@Q1"},{"id":32,"email":"10086@qq.com","nickname":"Fantasy","pwd":"Fantasy@1024"},{"id":33,"email":"150009312@qq.com","nickname":"follow","pwd":"Abcd&1234"},{"id":34,"email":"12345@qq.com","nickname":"66666666","pwd":"qweR123$"},{"id":36,"email":"123456@qq.com","nickname":"1111","pwd":"1234567Qq!"},{"id":38,"email":"948924223@qq.com","nickname":"wwww","pwd":"Abandon@123"},{"id":40,"email":"12345676@qq.com","nickname":"1234567","pwd":"Asdfghjkl!1"},{"id":41,"email":"814646226@qq.com","nickname":"hahah","pwd":"Haha1.jpg#"},{"id":43,"email":"999999@qq.com","nickname":"justfortest321","pwd":"123Buyaoshan!"},{"id":44,"email":"2222222@qq.com","nickname":"wzywwqeqe","pwd":"Wew!2312"},{"id":47,"email":"1288789@qq.com","nickname":"admindwad11","pwd":"HaHa123!"},{"id":49,"email":"22803430@qq.com","nickname":"mynick","pwd":"AaAa11!!"},{"id":51,"email":"123336789@qq.com","nickname":"admindwad","pwd":"HaHa123!"},{"id":55,"email":"41321231@qq.com","nickname":"daichi","pwd":"Oooo123~!"},{"id":57,"email":"77777777@qq.com","nickname":"77889911","pwd":"Zz666666!11"},{"id":62,"email":"2424566832@qq.com","nickname":"admin123","pwd":"Heihei1.jpg#"},{"id":63,"email":"11111111@qq.com","nickname":"wwwww","pwd":"Abcd@123"},{"id":64,"email":"1530009312@qq.com","nickname":"hhhhh","pwd":"Abcd&1234"},{"id":65,"email":"999942349@qq.com","nickname":"hhhhhg","pwd":"Abcd&1234"},{"id":66,"email":"778899@qq.com","nickname":"daichihaidilao","pwd":"HaHa123!!"},{"id":71,"email":"909090@qq.com","nickname":"909090","pwd":"P@ssw0rd"},{"id":72,"email":"12332112233@qq.com","nickname":"wwwwww","pwd":"123@qweQ"},{"id":73,"email":"112358@qq.com","nickname":"admin11235","pwd":"Admin123!"},{"id":74,"email":"7777777@qq.com","nickname":"Magic77","pwd":"Magic77!"},{"id":75,"email":"1106212522@qq.com","nickname":"Haoheihei","pwd":"A123456w!"}]}
```

#### getSearchAdmins

```json
{"code":0,"data":[]}
```

#### getAdminsInfo?id=29

```json
{
	"code": 0,
	"data": {
		"id": 1,
		"email": "admin",
		"nickname": "admin",
		"pwd": "admin"
	}
}
```

#### addAdminss

```json
{"code":0}

```
{nickname: "hahahhhahah", email: "243342354@qq.com", pwd: "ceshiJ123!"}

## 用户管理



#### allUser

```json
{"code":0,"data":[{"id":1,"email":"admin","nickname":"没事别改密码","pwd":"admin","recipient":"admin","address":"admin","phone":"11111111111"}]}
```

