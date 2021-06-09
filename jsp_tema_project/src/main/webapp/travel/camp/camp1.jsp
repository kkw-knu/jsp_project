<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
 <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="Description" content="�������� �Ѵ��� ã�ƺ��� ���ڽý��۱��� ���谡 ������ ��������.">
	<meta name="Keyword" content="������, ����Ʈ����, �鿣��, ����, ����, html, css, java, javascript, tomcat, jsp">
    <link href="https://fonts.googleapis.com/css2?family=Nanum+Gothic+Coding:wght@700&family=Noto+Sans+KR:wght@700&display=swap" rel="stylesheet">
	<link rel="preconnect" href="https://fonts.gstatic.com">
    <link href="../../css/bootstrap.min.css" rel="stylesheet" type="text/css">
    <script src="https://kit.fontawesome.com/012d5a0fd2.js" crossorigin="anonymous"></script>
    <script type="text/javascript" src="../../js/jquery.js"></script>
    <script type="text/javascript" src="../../js/bootstrap.min.js"></script>
    <script type="text/javascript" src="../../js/pooper.js"></script>
	<link href="../../css/init.css" rel="stylesheet" type="text/css">
    <link href="../../css/Header.css" rel="stylesheet" type="text/css">
<title>ķ��</title>
</head>
<body>
    <div>
        <div class="global_menu_wrap">
            <div class="fr">
                <ul>
                <c:set var="user_id" value="${sessionScope.user_id }"></c:set>
                <c:if test="${empty user_id }">
					<li><a href="loginform.do">�α���</a></li>
					<li><a>��</a></li>
                    <li><a href="joinform.do">ȸ������</a></li>
                    <li><a>��</a></li>
                    <li><a href="#none">������</a></li>
				</c:if>
                <c:if test="${not empty user_id }">
					<li><a><%=session.getAttribute("user_id") %> �� �ݰ����ϴ�</a></li>
					<li><a>��</a></li>
                    <li><a href="logout.do">�α׾ƿ�</a></li>
				</c:if>
                </ul>
            </div>
        </div>
        <div class="local_menu_wrap">
            <div class="fl">
                <div class="logo">
                    <a href="main.do">��������</a>
                </div>
            </div>
            <div class="fr">
                <div class="private_menu">
                    <ul>
                        <li>
                            <a href="mypage.do" class="sub_menu">
                                <i class="far fa-user-circle fa-2x"></i><div class="my">�� ����</div>
                            </a>
                        </li>
                        <li>
                            <a href="#" class="sub_menu">
                                <i class="far fa-edit fa-2x"></i><div class="my">�������</div>
                            </a>
                        </li>
                    </ul>
                </div>
            </div>
        </div>
    </div>
    <div style="height: 105px;"></div><!--�����-->
    <div class="list_menu">
        <div class="total_menu"><a href="#"><i class="fas fa-bars"></i> ��ü�޴�</div></a><!--onclick�� ��ü�޴� �Ѱ����-->
        <div class="total_sub_menu"><a href="main.do">����</a></div>
        <div class="total_sub_menu"><a href="#">������</a></div>
        <div class="total_sub_menu"><a href="#">����</a></div>
        <div class="total_sub_menu"><a href="#">QnA</a></div>
        <div class="total_sub_menu"><a href="#">��������</a></div>
    </div>
    <div>
<h1>ķ��</h1>
	<a href="bi_camp.jsp" ><img alt="" src="../images/camp/bi1.JPG" height="300" width="300"></a>
	<a href="hak_camp.jsp" ><img alt="" src="../images/camp/hak1.JPG" height="300" width="300"></a>
	<a href="juk_camp.jsp" ><img alt="" src="../images/camp/juk1.JPG" height="300" width="300"></a>
	<a href="mong_camp.jsp" ><img alt="" src="../images/camp/mong1.JPG" height="300" width="300"></a>
	<a href="wae_camp.jsp" ><img alt="" src="../images/camp/wae1.JPG" height="300" width="300"></a>
	<a href="yong_camp.jsp" ><img alt="" src="../images/camp/yong1.JPG" height="300" width="300"></a>
	</div>
 <div class="footer">
        <div class="fl">
            <div>
                <div>
                    <address class="footer_licensee">
                        <span><strong>(��)��������</strong></span><span>��</span>
                        <span>��ǥ : ȫ�浿, ��ö��</span><span>��</span>
                        <span>�ּ� : ���� ������ ���̷� 176 �߾Ӻ���</span>
                    </address>
                    <p class="footer_licensee">
                        <span>����ڵ�Ϲ�ȣ : 111-11-11111</span><span>��</span>
                        <span>�ѽ� : 111-111-1111</span><span>��</span>
                        <span>�̸��� : abcd@naver.com</span><span>��</span>
                        <span><strong>������ : 1577-1111</strong></span>
                    </p>
                    <p class="guide_txt">
                        �� �ε����� ������ ���� ���������� ����Ǵ� ��� �������Ǹ� �޽��ϴ�.<br>
                        �� ���������� �����ǰ�� ���Ͽ� ����Ǹ��߰��ڷμ� ����Ǹ� ����ڰ� �ƴϸ� �ش��ǰ�� �ŷ����� �� �ŷ�� ���� å���� ���� �ʽ��ϴ�.
                    </p>
                    <p class="copy">COPYRIGHT�� GWANGWANGGOTGOT SERVICE INC. ALL RIGHTS RESERVED</p>
                </div>
            </div>
        </div>
    </div>
</body>
</html>