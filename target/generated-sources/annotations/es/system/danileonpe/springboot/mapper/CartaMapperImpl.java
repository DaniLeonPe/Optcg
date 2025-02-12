package es.system.danileonpe.springboot.mapper;

import es.system.danileonpe.springboot.DTO.CartaDTO;
import es.system.danileonpe.springboot.model.Carta;
import es.system.danileonpe.springboot.model.Expansion;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-02-12T15:42:27+0000",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.14 (Oracle Corporation)"
)
public class CartaMapperImpl implements CartaMapper {

    @Override
    public CartaDTO toDTO(Carta carta) {
        if ( carta == null ) {
            return null;
        }

        int expansion = 0;
        String nombre = null;
        String tipo = null;
        String rareza = null;
        int costo = 0;
        String descripcion = null;
        String imagenUrl = null;

        expansion = cartaExpansionId( carta );
        nombre = carta.getNombre();
        tipo = carta.getTipo();
        rareza = carta.getRareza();
        costo = carta.getCosto();
        descripcion = carta.getDescripcion();
        imagenUrl = carta.getImagenUrl();

        int idCarta = 0;

        CartaDTO cartaDTO = new CartaDTO( idCarta, nombre, tipo, rareza, costo, descripcion, expansion, imagenUrl );

        return cartaDTO;
    }

    @Override
    public Carta toEntity(CartaDTO cartaDTO) {
        if ( cartaDTO == null ) {
            return null;
        }

        Carta carta = new Carta();

        carta.setExpansion( cartaDTOToExpansion( cartaDTO ) );
        carta.setNombre( cartaDTO.nombre() );
        carta.setTipo( cartaDTO.tipo() );
        carta.setRareza( cartaDTO.rareza() );
        carta.setCosto( cartaDTO.costo() );
        carta.setDescripcion( cartaDTO.descripcion() );
        carta.setImagenUrl( cartaDTO.imagenUrl() );

        return carta;
    }

    @Override
    public List<CartaDTO> toDTOList(List<Carta> cartas) {
        if ( cartas == null ) {
            return null;
        }

        List<CartaDTO> list = new ArrayList<CartaDTO>( cartas.size() );
        for ( Carta carta : cartas ) {
            list.add( toDTO( carta ) );
        }

        return list;
    }

    @Override
    public List<Carta> toEntityList(List<CartaDTO> cartaDTOs) {
        if ( cartaDTOs == null ) {
            return null;
        }

        List<Carta> list = new ArrayList<Carta>( cartaDTOs.size() );
        for ( CartaDTO cartaDTO : cartaDTOs ) {
            list.add( toEntity( cartaDTO ) );
        }

        return list;
    }

    private int cartaExpansionId(Carta carta) {
        if ( carta == null ) {
            return 0;
        }
        Expansion expansion = carta.getExpansion();
        if ( expansion == null ) {
            return 0;
        }
        int id = expansion.getId();
        return id;
    }

    protected Expansion cartaDTOToExpansion(CartaDTO cartaDTO) {
        if ( cartaDTO == null ) {
            return null;
        }

        Expansion expansion = new Expansion();

        expansion.setId( cartaDTO.expansion() );

        return expansion;
    }
}
