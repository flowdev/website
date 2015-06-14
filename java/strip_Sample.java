package org.flowdev.base;

public class Sample {
    
    public static class TellNames {
        private Port<String> outPort;    

        public void tell() {
            outPort.send("Harry");
            outPort.send("Joanne");
            outPort.send("Ron");
            outPort.send("Lily");
        }

        public void setOutPort(Port<String> outPort) {    
            this.outPort = outPort;
        }
    }
    
    
    public static class SayHello {
        private Port<String> inPort = name -> {    
            System.out.println("Hello, " + name + "!");
        };

        public Port<String> getInPort() {    
            return inPort;
        }
    }
    

    public static void main(String[] args) {
        
        TellNames tellNames = new TellNames();    
        SayHello sayHello = new SayHello();

        tellNames.setOutPort(sayHello.getInPort());    
        
        tellNames.tell();
    }
}

