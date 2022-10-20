<html>

<head>
	<title>
		GERENCIADOR SO
	</title>
</head>

<body style="text-align:center;" id="body">
	<h1 style="color:green;">
			Teste de Sistema Operacional
		</h1>
	<p id="GFG_UP"
	style="font-size: 19px;
			font-weight: bold;">
	</p>
	<button onclick="GFG_Fun()">
		CLIQUE AQUI
	</button>
	<p id="GFG_DOWN"
	style="color: green;
			font-size: 24px;
			font-weight: bold;">
	</p>
	<script>
		var el_up = document.getElementById("GFG_UP");
		var el_down = document.getElementById("GFG_DOWN");
		el_up.innerHTML = "Clique no botao para ver seu sistema";
		var Name = "Unknown OS";
		if (navigator.userAgent.indexOf("Win") != -1) Name =
		"Windows OS";
		if (navigator.userAgent.indexOf("Mac") != -1) Name =
		"Macintosh";
		if (navigator.userAgent.indexOf("Linux") != -1) Name =
		"Linux OS";
		if (navigator.userAgent.indexOf("Android") != -1) Name =
		"Android OS";
		if (navigator.userAgent.indexOf("like Mac") != -1) Name =
		"iOS";

		function GFG_Fun() {
			el_down.innerHTML = Name;
		}
	</script>
</body>

</html>
