raw text => hello [(${message})]
html attribute => th:*="${}"
string concatenation => th:*="|Hello ${message}|"

th:*="*{}" => th:object=p

th:insert=~{templateFile::templateName(var1, var2, var3)}
th:replace=~{templateFile:: templateName(var1,var2,var3)}

th:*="#{message}"