package com.example.tp5;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.tp5.Models.CategoriaInstrumento;
import com.example.tp5.Models.Instrumento;
import com.example.tp5.Repositories.CategoriaInstrumentoRepository;
import com.example.tp5.Repositories.InstrumentoRepository;

@SpringBootApplication
public class Tp5Application {

    private final InstrumentoRepository instrumentoRepository;
    private final CategoriaInstrumentoRepository categoriaInstrumentoRepository;

    public Tp5Application(InstrumentoRepository instrumentoRepository, CategoriaInstrumentoRepository categoriaInstrumentoRepository) {
        this.instrumentoRepository = instrumentoRepository;
        this.categoriaInstrumentoRepository = categoriaInstrumentoRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(Tp5Application.class, args);
    }

    @Bean
    CommandLineRunner init() {
        return args -> {
            if (!instrumentoRepository.existsByNombre("Guitarra Ukelele Infantil Grande 60cm")) {
                CategoriaInstrumento categoriaCuerda = new CategoriaInstrumento(null, "Cuerda");
                CategoriaInstrumento categoriaViento = new CategoriaInstrumento(null, "Viento");
                CategoriaInstrumento categoriaPercusion = new CategoriaInstrumento(null, "Percusión");
                CategoriaInstrumento categoriaTeclas = new CategoriaInstrumento(null, "Teclado");
                CategoriaInstrumento categoriaElectronicos = new CategoriaInstrumento(null, "Electrónico");

                categoriaInstrumentoRepository.save(categoriaCuerda);
                categoriaInstrumentoRepository.save(categoriaViento);
                categoriaInstrumentoRepository.save(categoriaPercusion);
                categoriaInstrumentoRepository.save(categoriaTeclas);
                categoriaInstrumentoRepository.save(categoriaElectronicos);

                // Creación manual de cada instrumento
                Instrumento mandolina = new Instrumento(null, "Mandolina Instrumento Musical Stagg Sunburst", "Stagg", "M20", "nro10.jpg", 2450.0, "Gratis", 28, "Estas viendo una excelente mandolina de la marca Stagg, con un sonido muy dulce, tapa aros y fondo de tilo, y diapasón de palisandro. Es un instrumento acústico (no se enchufa) de cuerdas dobles (4 pares) con la caja ovalada y cóncava, y el mástil corto. Su utilización abarca variados ámbitos, desde rock, folk, country y ensambles experimentales.", 1, categoriaCuerda);
                Instrumento pandereta = new Instrumento(null, "Pandereta Pandero Instrumento Musical", "DyM ventas", "32 sonajas", "nro9.jpg", 325.0, "150", 10, "1 Pandereta - 32 sonajas metálicas. Más de 8 años vendiendo con 100 % de calificaciones POSITIVAS y clientes satisfechos !!", 1, categoriaPercusion);
                Instrumento triangulo = new Instrumento(null, "Triangulo Musical 24 Cm Percusion", "LBP", "24", "nro8.jpg", 260.0, "250", 3, "Triangulo Musical de 24 Centímetros De Acero. ENVIOS POR CORREO O ENCOMIENDA: Se le deberán adicionar $40 en concepto de Despacho y el Costo del envío se abonará al recibir el producto en Terminal, Sucursal OCA o Domicilio", 1, categoriaPercusion);
                Instrumento barChimes = new Instrumento(null, "Bar Chimes Lp Cortina Musical 72 Barras", "FM", "LATIN", "nro7.jpg", 2250.0, "Gratis", 2, "BARCHIME CORTINA MUSICAL DE 25 BARRAS LATIN CUSTOM. Emitimos factura A y B", 1, categoriaViento);
                Instrumento shekeres = new Instrumento(null, "Shekeres. Instrumento. Música. Artesanía.", "Azalea Artesanías", "Cuentas de madera", "nro6.jpg", 850.0, "300", 5, "Las calabazas utilizadas para nuestras artesanías son sembradas y cosechadas por nosotros, quienes seleccionamos el mejor fruto para garantizar la calidad del producto y ofrecerle algo creativo y original.", 1, categoriaPercusion);
                Instrumento piano = new Instrumento(null, "Antiguo Piano Aleman Con Candelabros.", "Neumeyer", "Stratus", "nro3.jpg", 17000.0, "2000", 0, "Buen dia! Sale a la venta este Piano Alemán Neumeyer con candelabros incluidos. Tiene una talla muy bonita en la madera. Una pieza de calidad.", 1, categoriaTeclas);
                Instrumento ukelele = new Instrumento(null, "Guitarra Ukelele Infantil Grande 60cm", "GUITARRA", "UKELELE", "nro4.jpg", 500.0, "Gratis", 5, "Material: Plástico smil madera 4 Cuerdas longitud: 60cm, el mejor regalo para usted, su familia y amigos, adecuado para 3-18 años de edad", 1, categoriaCuerda);
                Instrumento teclado = new Instrumento(null, "Teclado Organo Electronico Musical Instrumento 54 Teclas", "GADNIC", "T01", "nro2.jpg", 2250.0, "Gratis", 1375, "Organo Electrónico GADNIC T01. Display de Led. 54 Teclas. 100 Timbres / 100 Ritmos. 4 1/2 octavas. 8 Percusiones. 8 Canciones de muestra. Grabación y reproducción. Entrada para Micrófono. Salida de Audio (Auriculares / Amplificador). Vibrato. Sustain Incluye Atril Apoya partitura y Micrófono. Dimensiones: 84,5 x 32,5 x 11 cm", 1, categoriaElectronicos);
                Instrumento setPercusion = new Instrumento(null, "Instrumentos De Percusión Niños Set Musical Con Estuche", "KNIGHT", "LB17", "nro1.jpg", 2700.0, "300", 15, "Estas viendo un excelente y completísimo set de percusion para niños con estuche rígido, equipado con los instrumentos mas divertidos! De gran calidad y sonoridad. Ideal para jardines, escuelas primarias, musicoterapeutas o chicos que se quieran iniciar en la música de la mejor manera. Es un muy buen producto que garantiza entretenimiento en cualquier casa o reunión, ya que esta equipado para que varias personas al mismo tiempo estén tocando un instrumento.", 1, categoriaPercusion);
                Instrumento bateriaInfantil = new Instrumento(null, "Batería Musical Infantil Juguete Niño 9 Piezas Palillos", "Bateria", "Infantil", "nro5.jpg", 850.0, "250", 380, "DESCRIPCIÓN: DE 1 A 3 AÑOS. EL SET INCLUYE 5 TAMBORES, PALILLOS Y EL PLATILLO TAL CUAL LAS FOTOS. SONIDOS REALISTAS Y FÁCIL DE MONTAR. MEDIDAS: 40X20X46 CM", 1, categoriaPercusion);

                instrumentoRepository.save(shekeres);
                instrumentoRepository.save(piano);
                instrumentoRepository.save(ukelele);
                instrumentoRepository.save(teclado);
                instrumentoRepository.save(setPercusion);
                instrumentoRepository.save(bateriaInfantil);
                instrumentoRepository.save(mandolina);
                instrumentoRepository.save(pandereta);
                instrumentoRepository.save(triangulo);
                instrumentoRepository.save(barChimes);

            }
        };
    }

}
