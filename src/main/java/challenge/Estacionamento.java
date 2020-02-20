package challenge;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Estacionamento {

    private List<Carro> carros = new ArrayList<>();

    public void estacionar(Carro carro) {
        if (carro.getMotorista() == null ||
                carro.getMotorista().getIdade() < 18 ||
                carro.getMotorista().getPontos() > 20) {
            throw new EstacionamentoException("Não é permitido estacionar!");
        } else {
            if (carros.size() > 9) {
                Optional<Carro> proximo = carros.stream().filter(fila -> fila.getMotorista().getIdade() < 55).findFirst();
                if (proximo.isPresent()) {
                    carros.remove(proximo.get());
                } else {
                    throw new EstacionamentoException("Não é permitido estacionar!");
                }
            }
            carros.add(carro);
        }
    }

    public int carrosEstacionados() {
        return carros.size();
    }

    public boolean carroEstacionado(Carro carro) {
        return carros.contains(carro);
    }
}
