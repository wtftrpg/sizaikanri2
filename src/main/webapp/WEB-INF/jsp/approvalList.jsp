<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page pageEncoding="UTF-8"%>
<%@ include file="menu.jsp"%>
<html>
<head>
<title>購入承認一覧</title>
<script type="text/javascript">
    function openApprovalDetail(sizaiId) {
        // ウィンドウのサイズや位置を指定して小ウィンドウを開く
        window.open('/sizaikanri/approvalDetail/init?form.sizaiId=' + sizaiId, 'approvalDetail', 'width=800,height=600,scrollbars=yes,resizable=yes');
    }
</script>
</head>
<body>
	<h2>購入承認一覧</h2>

	<form name="form" action="/sizaikanri/approvalList/search" method="post">
	<div>
	   開始日付:<input type="date" name="form.startDate" value="<s:property value="form.startDate"/>" />
	   終了日付:<input type="date" name="form.endDate" value="<s:property value="form.endDate"/>" />
	   <input type="submit" value="検索"/>
	</div>
	</form>

	<s:if test="form.list != null && form.list.size !=0">

	<table class="outputtable">
	<tr>
		<th>資材ID</th>
		<th>資材名</th>
		<th>数量</th>
		<th>カテゴリ</th>
		<th>購入依頼者</th>
		<th>購入依頼部門</th>
		<th>状態</th>
		<th>依頼日</th>
		<th>承認</th>
		<th>却下</th>

	</tr>
	<s:iterator value="form.list">
	<tr>
		<td>
			<s:property value="id"/>
		</td>
        <td>
            <!-- 資材名をクリックすると小ウィンドウで詳細ページを開く -->
            <a href="javascript:void(0);" onclick="openApprovalDetail('<s:property value="id"/>');">
                <s:property value="name"/>
            </a>
        </td>
		<td>
			<s:property value="num"/>
		</td>
		<td>
			<s:property value="category_name"/>
		</td>
		<td>
			<s:property value="request_user_name"/>
		</td>
		<td>
			<s:property value="request_dept_name"/>
		</td>
		<td>
			<s:property value="status_name"/>
		</td>
		<td>
			<s:property value="request_date"/>
		</td>
		<td>
		   	<s:if test="status == 1 || status == 3">
		   	 <a href="/sizaikanri/approvalList/approval?form.sizaiId=<s:property value="id"/>">承認</a>
		   	 </s:if>
		</td>
		<td>
		   	<s:if test="status == 1">
		   	 <a href="/sizaikanri/approvalList/regect?form.sizaiId=<s:property value="id"/>">却下処理</a>
		   	 </s:if>
		</td>
	</tr>
	</s:iterator>
	</table>
	</s:if>
	<br/>
	<hr/>
	
</body>
</html>

