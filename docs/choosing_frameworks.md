# フレームワークの選定

## 要約

- デプロイも含めた開発効率向上のためSpring Bootでmicroservice化する。
- Viewのフレームワークとしてthymeleafがよく言及されるが、thymeleafの目的は「JSPの代替技術。より自然なhtmlでViewを表現できる」
  - 正直このご利益はどうでもいいことと思う。
  - JavaならJSPを使うのが自然であり、複数のページの見てくれを統一するやり方はApache Tilesで完成している。



## Apache Tiles

### 参考文献

Spring5 + tilesのtutorialとしては以下の記事がある。

- [Bealdung, Apache Tiles Integration with Spring MVC (2018)](https://www.baeldung.com/spring-mvc-apache-tiles)


- [Github, spring-boot-web-mvc-tiles3 (2014)](https://github.com/mmeany/spring-boot-web-mvc-tiles3)




結局
以下をテンプレートとして使うこととした。

[Github, spring-boot-web-mvc-tiles3 (2014)](https://github.com/mmeany/spring-boot-web-mvc-tiles3)

ポイントは以下の通り。

- ドキュメントが十分書いてある。
- そのままだとwarファイルができるが、これをtomcat配下に入れるのではなくmicroservice的にwarの中にtomcatが入る形になっている。
- Java9からJavaEEの構成が変わってしまったため、そのままではJava9以降のJDKでは動かない。
  - https://stackoverflow.com/questions/43574426/how-to-resolve-java-lang-noclassdeffounderror-javax-xml-bind-jaxbexception-in-j
  - このエラーが起こらないようにするには、spring-boot-starter-parentのバージョンを2.x系統にあげればよい。


