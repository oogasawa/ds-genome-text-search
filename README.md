# DS-text-search

GFFファイルの検索とJBrowseとの連携




## 使い方

ブラウザで http://localhost:8000/search にアクセスすると以下のような画面が表示される。

![Screen001.png](docs/images/Screen001.png)

- 検索語を何も指定しないとgff3ファイルの全データが表示される。
- データにマウスオーバーすると行の背景色が反転する。
- 左端の青いリンクアイコンをクリックするとJBrowserで該当箇所が表示される。


検索語は正規表現で指定する。単に行全体に対して正規表現を探すので該当の文字列を入れるだけで文字列の途中のマッチを探すことができる。

![Screen002.png](docs/images/Screen002.png)


メタキャラクタを使った正規表現の例は以下の通り。

![Screen003.png](docs/images/Screen003.png)



