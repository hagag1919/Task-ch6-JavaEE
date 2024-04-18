package services;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import ejbs.Calculation;

@Stateless
@Path("")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class AppServices {
   @PersistenceContext(unitName="hello")
       private EntityManager entityManager;

    public AppServices() {
    }

    @POST
   @Path("/calc")
    public CalculationResult calculate(Calculation request) {
        int result = request.calculate();
        entityManager.persist(request);
        return new CalculationResult(result);
    }
    
    @GET
    @Path("/calculations")
    
	public List<Calculation> getCalculations() {
		return entityManager.createQuery("SELECT c FROM Calculation c", Calculation.class).getResultList();
	}
    
    
    
    
    

    public static class CalculationRequest {
        private String operation;
        private int number1;
        private int number2;

        public String getOperation() {
            return operation;
        }

        public void setOperation(String operation) {
            this.operation = operation;
        }

        public int getNum1() {
            return number1;
        }

        public void setNum1(int num1) {
            this.number1 = num1;
        }

        public int getNum2() {
            return number2;
        }

        public void setNum2(int num2) {
            this.number2 = num2;
        }
    }

    public static class CalculationResult {
        private int result;

        public CalculationResult(int result) {
            this.result = result;
        }

        public int getResult() {
            return result;
        }

        public void setResult(int result) {
            this.result = result;
        }
    }
}
