package OpenClosedPrinciple;

public class Main{
    PaymentService paymentService = new PaymentService();
    private Map<String, PaymentStrategy> paymentProcessors = new HashMap();

    Main(){
        paymentProcessors.put("CreditCard", new CreditCardPayment());
        paymentProcessors.put("PayPal", new PayPalPayment());
        paymentProcessors.put("Boleto", new BoletoPayment());
        paymentProcessors.put("Pix", new PixPayment());
    }

    private void processPayment(double amount, PaymentType paymentType){
        PaymentStrategy paymentStrategy = getStrategy(paymentType);
        paymentService.setPaymentStrategy(paymentStrategy);
        paymentService.processPayment(amount);
    }

    private PaymentStrategy getStrategy(paymentType){
        return paymentProcessors.get(paymentType);
    }
    
    /*passos para a Strategy
    * 1 - uma estrategia (forma de cumprir o objetivo)
    * 2 - implementação da estrategia (implements e override)
    * 3 - contexto (o que irá definir qual a estrategia a ser utilizada)
    */
}


