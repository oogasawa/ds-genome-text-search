# DS-text-search

GFFファイルの検索とJBrowseとの連携

## 更新履歴

- version 0.2.0
  - 基本的な機能を実装した。
- version 0.1.0 
  - Spring Boot ver.5 + Apache Tiles ver.3 でコンパイルが成功する最低限の雛形を作成。[Github, spring-boot-web-mvc-tiles3 (2014)](https://github.com/mmeany/spring-boot-web-mvc-tiles3)をベースにしてパッケージ名などを調整した。

## インストール方法

### 前提

- Java version 10
- Apache maven version 3.5.3
- git (version 2.15.2)

### コンパイル方法

	git clone http://gitlab.ddbj.nig.ac.jp/oogasawa/ds-text-search
	cd ds-text-search
	mvn -Dmaven.test.skip=true clean package
	
これによりtargetディレクトリの下にds-text-search-0.2.0.jarファイルが生成される。

### 起動方法

以下のコマンドでds-text-searchが動作するwebサーバーが8080番ポートで起動する。

    java -jar target/ds-text-search-0.2.0.jar \
	    --server.port=8080 \
		--datafile=/home/your-account/your-data.gff3

あとはブラウザで http://localhost:8080/search にアクセスすれば良い。






