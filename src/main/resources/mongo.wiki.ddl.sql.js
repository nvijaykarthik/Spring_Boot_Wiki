db.createCollection("book");
db.book.createIndex({"urlFriendlyName":1},{unique:true});
db.book.createIndex({"name":1},{unique:true});

db.createCollection("page");
db.page.createIndex({"urlFrendlyTitle":1},{unique:true});
db.page.createIndex({"title":1},{unique:true});


