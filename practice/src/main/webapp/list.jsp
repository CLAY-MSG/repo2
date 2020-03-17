<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <%--<meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>--%>
    <title>list</title>
    <!-- 1. 导入CSS的全局样式 -->
    <%--<link href="css/bootstrap.min.css" rel="stylesheet">
    <!-- 2. jQuery导入，建议使用1.9以上的版本 -->
    <script src="js/jquery-2.1.0.min.js"></script>
    <!-- 3. 导入bootstrap的js文件 -->
    <script src="js/bootstrap.min.js"></script>
    <script type="text/javascript"></script>--%>
    <script src=${pageContext.request.contextPath}/statics/js/jquery-3.3.1.js></script>
    <script>
        $.get("bill/findAllBill",{},function (billList) {
            var strs = "";
            for (var i = 0; i < billList.length; i++) {
                var bill = billList[i];
                if (bill.isPayment==1){
                    var str = "<tr><td>"+bill.billCode+"</td><td>"+bill.productName+"</td><td>"+bill.proName+"</td><td>"+bill.totalPrice+"</td><td>是</td><td>"+bill.creationDate+"</td></tr>";
                }else if (bill.isPayment==2){
                    var str = "<tr><td>"+bill.billCode+"</td><td>"+bill.productName+"</td><td>"+bill.proName+"</td><td>"+bill.totalPrice+"</td><td>否</td><td>"+bill.creationDate+"</td></tr>";
                }
                strs += str;
            }
            $("#practiceTable").html(strs);
        });
        $(function () {
            $("#practiceForm").submit(function () {
                $.get("",this.serialize(),function () {

                })
            })
        })
    </script>
</head>
<body>
<form id="practiceForm">
    <label for="productName">商品名称</label>
    <input type="text" name="productName" id="productName">
    <label for="proName">供应商</label>
    <input type="text" name="proName" id="proName">
    <label for="isPayment">是否付款</label>
    <input type="text" name="isPayment" id="isPayment">
    <button type="submit" value="搜索">搜索</button>
</form>
<table id="practiceTable">

</table>
</body>
</html>
