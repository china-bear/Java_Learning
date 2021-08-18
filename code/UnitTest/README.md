Unit 是用于进行单元测试的。但是 Junit 5 和 Junit 4 的区别比较大。
很多时候你可能会遇到 Junit 引擎配置错误导致测试无法进行。


junit-jupiter-api
JUnit 5 Jupiter API 的测试，你需要使用这个 API 来写测试和进行扩展。


junit-jupiter-engine
JUnit 5 的测试引擎，从 Junit 5 开始，Junit 使用 jupiter 来作为测试引擎。在运行时（runtime）的时候，你需要使用这个引擎来进行测试。


junit-vintage-engine
针对 Junit 5 以下的版本，包括 Junit 4 和 3，Junit 使用的是 vintage 测试引擎。
如果你的测试使用的是 Junit 4 的代码进行编写的话，那么你需要 Junit 4 的测试引擎。
总结: 需要 junit-jupiter-api 和 junit-jupiter-engine 来在 Junit 5 中书写和运行测试。

JUnit 4 项目, 需要将 junit-jupiter-engine 引擎替换为 junit-vintage-engine 引擎才能够让你的测试正式跑起来。

-- https://zhuanlan.zhihu.com/p/265210344