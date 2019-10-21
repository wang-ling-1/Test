$(function() {
    fillTable();
    $("#orderQueryButton").click(function() {
        queryButtonClick();
    })

    $("#orderQueryResetButton").click(function() {
        queryResetButtonClick();
    });
    $("#gotoPageButton").click(function() {
        gotoPageButtonClick();
    });
});

function gotoPage(gotoPage) {
    $("#gotoPageHidden").val(gotoPage);
    $("#gotoPageText").val(gotoPage);

    fillTable();
}
function queryButtonClick() {
    $("#gotoPageHidden").val("1");
    fillTable();
}
function queryResetButtonClick() {
    $("#ordernumber").val("");
    $("#orderalipaynumber").val("");
    $("#ordertime").val("");
    $("#orderbuyername").val("");
    $("#ordersellername").val("");
    $("#ordercommodity").val("");
    $("#gotoPageHidden").val("1");
    fillTable();
}
function gotoPageButtonClick() {
    var gotoPageValue = $("#gotoPageText").val();
    $("#gotoPageHidden").val(gotoPageValue);
    fillTable();
}
function fillTable() {
    var allTR = $("#advertTable").find("tr");
    var firstTR = $("#advertTable").find("tr:first");
    var otherTR = $(allTR).not(firstTR);
    $(otherTR).find("td").text("");

    ordernumber, orderalipaynumber, ordertime, orderbuyername,
        ordersellername, ordercommodity, hidden

    var ordernumber = $("#ordernumber").val();
    var orderalipaynumber = $("#orderalipaynumber").val();
    var ordertime = $("#ordertime").val();
    var orderbuyername = $("#orderbuyername").val();
    var ordersellername = $("#ordersellername").val();
    var ordercommodity = $("#ordercommodity").val();
    var hidden = $("#gotoPageHidden").val();

    $("#gotoPageText").val(hidden);

    var beginValue = (hidden - 1) * 9;


    $.post("GetOrderPage?t=" + new Date().getTime(),
        {
            "ordernumber" : ordernumber,
            "orderalipaynumber" : orderalipaynumber,
            "ordertime" : ordertime,
            "orderbuyername" : orderbuyername,
            "ordersellername" : ordersellername,
            "ordercommodity" : ordercommodity,
            "hidden" : hidden
        },
        function(data) {
            var jsonObject = JSON.parse(data);
            if(jsonObject.code=="1"){
                alert("程序出错,请联系管理员");
                return;
            }
            var orderList = jsonObject.returnValue.pageData;
            for (var i = 0; i < orderList.length; i++) {
                var order = orderList[i];
                var orderId = order.id;
                var orderNumber = order.orderNumber;
                var orderAlipayNumber = order.orderAlipayNumber;
                var orderTime = order.orderTime;
                var orderActualPayment = order.orderActualPayment;
                var orderPayMethodParam = order.orderPayMethod;
                var orderPayMethod="";
                if(orderPayMethodParam=="1"){
                    orderPayMethod="支付宝";
                }
                if(orderPayMethodParam=="2"){
                    orderPayMethod="银行卡";
                }
                var orderBuyerName = order.orderBuyerName;
                var orderSellerName = order.orderSellerName;
                var orderCommodity = order.orderCommodity;
                var orderStateParam = order.orderState;
                var orderState="";
                if(orderStateParam=="0"){
                    orderState="未支付";
                }
                if(orderStateParam=="1"){
                    orderState="已支付";
                }
                if(orderStateParam=="2"){
                    orderState="申请退款";
                }
                if(orderStateParam=="3"){
                    orderState="已退款";
                }

                var findTR = $("#tr" + (i + 1));
                var td_1 = $(findTR).find("td:eq(0)");
                $(td_1).text(beginValue + i + 1);

                var td_2 = $(findTR).find("td:eq(1)");
                $(td_2).text(orderId);

                var td_3 = $(findTR).find("td:eq(2)");
                $(td_3).text(orderNumber);

                var td_4 = $(findTR).find("td:eq(3)");
                $(td_4).text(orderAlipayNumber);

                var td_5 = $(findTR).find("td:eq(4)");
                $(td_5).text(orderTime);

                var td_6 = $(findTR).find("td:eq(5)");
                $(td_6).text(orderActualPayment);

                var td_7 = $(findTR).find("td:eq(6)");
                $(td_7).text(orderPayMethod);

                var td_8 = $(findTR).find("td:eq(7)");
                $(td_8).text(orderBuyerName);

                var td_9 = $(findTR).find("td:eq(8)");
                $(td_9).text(orderSellerName);

                var td_10 = $(findTR).find("td:eq(9)");
                $(td_10).text(orderCommodity);

                var td_11 = $(findTR).find("td:eq(10)");
                $(td_11).text(orderState);
            }

            var gotoPage = jsonObject.returnValue.gotoPage;
            var first = gotoPage.first;
            var prev = gotoPage.prev;
            var next = gotoPage.next;
            var last = gotoPage.last;
            $("#firstButton").attr("onclick",
                "gotoPage(" + first + ")");
            $("#prevButton").attr("onclick",
                "gotoPage(" + prev + ")");
            $("#nextButton").attr("onclick",
                "gotoPage(" + next + ")");
            $("#lastButton").attr("onclick",
                "gotoPage(" + last + ")");

            var totalCount = gotoPage.getAllPageCount;
            var CurrentCount = gotoPage.getCurrentPageCount;

            $("#queryAllRowCount").html(
                "&nbsp;&nbsp;&nbsp;当前条件总记录数：" + totalCount
                + "&nbsp;&nbsp;&nbsp;");
            $("#queryCurrentPageRowCount").html(
                "&nbsp;&nbsp;&nbsp;当前页总记录数：" + CurrentCount
                + "&nbsp;&nbsp;&nbsp;");

        });
}
