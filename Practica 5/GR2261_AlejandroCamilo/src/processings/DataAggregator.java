package processings;

import java.util.*;

/**
 * Clase data aggregator. Introduciremos una serie de elementos e imprimiremos su resultado como un Map. Por ello,
 * debemos implementar la interfaz Map.
 * 
 * @author EstudianteEPS alejandror.hurtado@estudiante.uam.es
 * @author EstudianteEPS camilo.jenec@estudiante.uam.es
 */
public class DataAggregator implements Map<String, List<Object>>{
    /**
     * Lista de llaves del map.
     */
    private List<String> keys = new ArrayList<>();
    
    /**
     * Lista de valores por cada llave del map.
     */
    private List<List<Object>> values = new ArrayList<>();

    /**
     * Metodo add del Map. introduciremos los datos a partir de otro map.
     * 
     * @param form Map recibido del que obtenemos los datos.
     */
    public void add(Map<String, ?> form) {
        int i = 0;
        for (String key : form.keySet()) {
            if (encontrarIndice(key) >= 0) {
                // Comprobar todos y meterlo justo antes del que sea mayor
                if (encontrarIndice(key) == 1) {
                    for (Object o : values.get(1)) {
                        if ((int)o > (int)form.get(key)) {
                            values.get(encontrarIndice(key)).add(i, form.get(key));
                            values.get(0).add(i, values.get(0).get(values.get(0).size() - 1));
                            values.get(0).remove(values.get(0).size() - 1);
                            break;
                        }
                    }
                } else {
                    values.get(encontrarIndice(key)).add(form.get(key));
                }
            } else {
                keys.add(key);
                values.add(new ArrayList<>(Arrays.asList(form.get(key))));
            }
        }
    }
    
    /**
     * Metotodo toString en el que imprimimos el dataAggregator con la forma del map.
     * 
     * @return String
     */
    public String toString() {
        int i = 0;
        String texto = "{";

        for (String k : keys) {
            texto += k + " = " + values.get(i);
            i++;

            if (i < keys.size())
                texto += ", ";
        }

        texto += "}";

        return texto;
    }

    /**
     * Tamanyo del map.
     * 
     * @return int
     */
    @Override
    public int size() {
        return keys.size();
    }

    /**
     * Metodo que devuelve si el map esta vacio o no.
     *
     * @return boolean 
     */
    @Override
    public boolean isEmpty() {
        return keys.isEmpty();
    }

    /** 
     * Metodo que devuelve si el map contiene la key pasada por parametro.
     * 
     * @param key clave a buscar.
     * @return boolean
    */
    @Override
    public boolean containsKey(Object key) {
        return keys.contains(key);
    }

    
    /** 
     * Metodo que devuelve si el mapa contiene el valor o no.
     * 
     * @param value valor a comprobar.
     * @return boolean
     */
    @Override
    public boolean containsValue(Object value) {
        return values.contains(value);
    }

    
    /** 
     * Metodo que obtiene el valor según la clave pasada por parámetro.
     * 
     * @param key Clave a comprobar.
     * @return List
     */
    @Override
    public List<Object> get(Object key) {
        int value = encontrarIndice(key);

        return value >= 0 ? values.get(value) : null;
    }

    
    /**
     * Metodo que introduce la clave y el valor.
     * 
     * @param key Clave a introducir.
     * @param value Valor a introducir.
     * @return List
     */
    @Override
    public List<Object> put(String key, List<Object> value) {
        return null;
    }

    
    /**
     * Metodo que elimina el valor y la clave del mapa.
     * 
     * @param key Clave a eliminar.
     * @return List
     */
    @Override
    public List<Object> remove(Object key) {
        int valor = encontrarIndice(key);

        keys.remove(valor);

        return values.remove(valor);
    }

    
    /** 
     * Metodo que introduce todo un mapa en éste.
     * 
     * @param m Map a introducir.
     */
    @Override
    public void putAll(Map<? extends String, ? extends List<Object>> m) {
        keys.addAll(m.keySet());
        values.addAll(m.values());
    }

    /**
     * Metodo que limpia el map.
     */
    @Override
    public void clear() {
        keys.clear(); values.clear();
    }

    
    /** 
     * Metodo que devuelve el set de claves.
     * 
     * @return Set
     */
    @Override
    public Set<String> keySet() {
        return new HashSet<String>(keys);
    }

    
    /** 
     * Metodo que devuelve la coleccion de valores.
     * 
     * @return Collection
     */
    @Override
    public Collection<List<Object>> values() {
        return values;
    }

    
    /** 
     * @return Set
     */
    @Override
    public Set<Entry<String, List<Object>>> entrySet() {
        return null;
    }

    
    /** 
     * Metodo que devuelve el indice en el que se encuentra la clave.
     * 
     * @param key Clave a buscar.
     * @return int
     */
    private int encontrarIndice(Object key) {
        for (int i = 0; i < keys.size(); i++) {
            if (keys.get(i).equals(key))
                return i;
        }

        return -1;
    }
}
