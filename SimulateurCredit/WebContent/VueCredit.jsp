<%@page import="web.CreditModel"%>
<%
	CreditModel mod = (CreditModel) request.getAttribute("mod");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Simulateur Crédit</title>
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="css/style.css">

</head>
<body>
	<p class="spacer"></p>
	<div class="container">
		<div class="col-md-6 col-xm-12 col-sm-6 col-md-offset-3">


			<div class="panel panel-primary">
				<div class="panel-heading">Simulation du crédit</div>
				<div class="panel-body">
					<form action="controleur.php" method="post">
						<div class="form-group">
							<label class="control-label">Montant :</label> <input
								class="form-control" type="text" name="montant"
								value="<%=mod.getMontant()%>" />
						</div>

						<div class="form-group">
							<label class="control-label">Taux :</label> <input
								class="form-control" type="text" name="taux"
								value="<%=mod.getTaux()%>" />
						</div>

						<div class="form-group">
							<label class="control-label">Durée :</label> <input
								class="form-control" type="text" name="duree"
								value="<%=mod.getDuree()%>" />
						</div>

						<button class="btn btn-danger">Calculer</button>
					</form>
					<div class="spacer">
						<label>Mensualité à payer :</label> <label><%=mod.getMensualite()%></label>
					</div>
				</div>
			</div>
		</div>
	</div>

</body>
</html>