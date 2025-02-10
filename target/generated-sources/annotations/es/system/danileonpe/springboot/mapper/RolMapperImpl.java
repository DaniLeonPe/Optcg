package es.system.danileonpe.springboot.mapper;

import es.system.danileonpe.springboot.DTO.RolDTO;
import es.system.danileonpe.springboot.model.Rol;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-02-10T11:03:30+0000",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.14 (Oracle Corporation)"
)
public class RolMapperImpl implements RolMapper {

    @Override
    public Rol toEntity(RolDTO rolDto) {
        if ( rolDto == null ) {
            return null;
        }

        Rol rol = new Rol();

        rol.setId( rolDto.id() );
        rol.setName( rolDto.name() );

        return rol;
    }

    @Override
    public RolDTO toDTO(Rol rolEntity) {
        if ( rolEntity == null ) {
            return null;
        }

        int id = 0;
        String name = null;

        id = rolEntity.getId();
        name = rolEntity.getName();

        RolDTO rolDTO = new RolDTO( id, name );

        return rolDTO;
    }

    @Override
    public List<Rol> toEntityList(List<RolDTO> rolDtos) {
        if ( rolDtos == null ) {
            return null;
        }

        List<Rol> list = new ArrayList<Rol>( rolDtos.size() );
        for ( RolDTO rolDTO : rolDtos ) {
            list.add( toEntity( rolDTO ) );
        }

        return list;
    }

    @Override
    public List<RolDTO> toDTOList(List<Rol> rolEntities) {
        if ( rolEntities == null ) {
            return null;
        }

        List<RolDTO> list = new ArrayList<RolDTO>( rolEntities.size() );
        for ( Rol rol : rolEntities ) {
            list.add( toDTO( rol ) );
        }

        return list;
    }
}
