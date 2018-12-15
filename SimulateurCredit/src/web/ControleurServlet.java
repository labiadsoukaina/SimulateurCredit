package web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import metier.CreditMetier;

@WebServlet(name="cs", urlPatterns={"/controleur","*.php"})
public class ControleurServlet extends HttpServlet {
	private CreditMetier metier;
	
	@Override
	public void init() throws ServletException {
		metier = new CreditMetier();
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		req.setAttribute("mod", new CreditModel());//test
		
		req.getRequestDispatcher("VueCredit.jsp").forward(req,resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//lire les données saisies ---- Ces 7 lignes suivantes sont faites par le FrameWork
		double montant = Double.parseDouble(req.getParameter("montant"));
		double taux = Double.parseDouble(req.getParameter("taux"));
		int duree = Integer.parseInt(req.getParameter("duree"));
		CreditModel model = new CreditModel();
		//stocker les données dans le model
		model.setMontant(montant);
		model.setTaux(taux);
		model.setDuree(duree);
		
		double res=metier.calculMensualite(montant, duree, taux);
		
		model.setMensualite(res);
		
		req.setAttribute("mod", model);
		req.getRequestDispatcher("VueCredit.jsp").forward(req,resp);	
		
	}
}
