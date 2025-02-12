package es.system.danileonpe.springboot.mapper;

import es.system.danileonpe.springboot.DTO.MazoCartaDTO;
import es.system.danileonpe.springboot.model.Carta;
import es.system.danileonpe.springboot.model.Mazo;
import es.system.danileonpe.springboot.model.MazoCarta;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-02-12T19:36:25+0000",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.14 (Oracle Corporation)"
)
public class MazoCartaMapperImpl implements MazoCartaMapper {

    @Override
    public MazoCartaDTO toDTO(MazoCarta mazoCarta) {
        if ( mazoCarta == null ) {
            return null;
        }

        int idMazo = 0;
        int idCarta = 0;
        int id = 0;
        int cantidad = 0;

        idMazo = mazoCartaMazoId( mazoCarta );
        idCarta = mazoCartaCartaId( mazoCarta );
        id = mazoCarta.getId();
        cantidad = mazoCarta.getCantidad();

        MazoCartaDTO mazoCartaDTO = new MazoCartaDTO( id, idMazo, idCarta, cantidad );

        return mazoCartaDTO;
    }

    @Override
    public MazoCarta toEntity(MazoCartaDTO mazoCartaDTO) {
        if ( mazoCartaDTO == null ) {
            return null;
        }

        MazoCarta mazoCarta = new MazoCarta();

        mazoCarta.setMazo( mazoCartaDTOToMazo( mazoCartaDTO ) );
        mazoCarta.setCarta( mazoCartaDTOToCarta( mazoCartaDTO ) );
        mazoCarta.setId( mazoCartaDTO.id() );
        mazoCarta.setCantidad( mazoCartaDTO.cantidad() );

        return mazoCarta;
    }

    @Override
    public List<MazoCartaDTO> toDTOList(List<MazoCarta> mazoCartas) {
        if ( mazoCartas == null ) {
            return null;
        }

        List<MazoCartaDTO> list = new ArrayList<MazoCartaDTO>( mazoCartas.size() );
        for ( MazoCarta mazoCarta : mazoCartas ) {
            list.add( toDTO( mazoCarta ) );
        }

        return list;
    }

    @Override
    public List<MazoCarta> toEntityList(List<MazoCartaDTO> mazoCartaDTOs) {
        if ( mazoCartaDTOs == null ) {
            return null;
        }

        List<MazoCarta> list = new ArrayList<MazoCarta>( mazoCartaDTOs.size() );
        for ( MazoCartaDTO mazoCartaDTO : mazoCartaDTOs ) {
            list.add( toEntity( mazoCartaDTO ) );
        }

        return list;
    }

    private int mazoCartaMazoId(MazoCarta mazoCarta) {
        if ( mazoCarta == null ) {
            return 0;
        }
        Mazo mazo = mazoCarta.getMazo();
        if ( mazo == null ) {
            return 0;
        }
        int id = mazo.getId();
        return id;
    }

    private int mazoCartaCartaId(MazoCarta mazoCarta) {
        if ( mazoCarta == null ) {
            return 0;
        }
        Carta carta = mazoCarta.getCarta();
        if ( carta == null ) {
            return 0;
        }
        int id = carta.getId();
        return id;
    }

    protected Mazo mazoCartaDTOToMazo(MazoCartaDTO mazoCartaDTO) {
        if ( mazoCartaDTO == null ) {
            return null;
        }

        Mazo mazo = new Mazo();

        mazo.setId( mazoCartaDTO.idMazo() );

        return mazo;
    }

    protected Carta mazoCartaDTOToCarta(MazoCartaDTO mazoCartaDTO) {
        if ( mazoCartaDTO == null ) {
            return null;
        }

        Carta carta = new Carta();

        carta.setId( mazoCartaDTO.idCarta() );

        return carta;
    }
}
