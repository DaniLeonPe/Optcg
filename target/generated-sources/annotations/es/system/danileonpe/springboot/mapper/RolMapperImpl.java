package es.system.danileonpe.springboot.mapper;

import es.system.danileonpe.springboot.DTO.RolDTO;
import es.system.danileonpe.springboot.model.Role;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-02-12T15:42:27+0000",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.14 (Oracle Corporation)"
)
public class RolMapperImpl implements RolMapper {

    @Override
    public Role toEntity(RolDTO rolDto) {
        if ( rolDto == null ) {
            return null;
        }

        Role role = new Role();

        role.setId( rolDto.id() );
        role.setName( rolDto.name() );

        return role;
    }

    @Override
    public RolDTO toDTO(Role rolEntity) {
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
    public List<Role> toEntityList(List<RolDTO> rolDtos) {
        if ( rolDtos == null ) {
            return null;
        }

        List<Role> list = new ArrayList<Role>( rolDtos.size() );
        for ( RolDTO rolDTO : rolDtos ) {
            list.add( toEntity( rolDTO ) );
        }

        return list;
    }

    @Override
    public List<RolDTO> toDTOList(List<Role> rolEntities) {
        if ( rolEntities == null ) {
            return null;
        }

        List<RolDTO> list = new ArrayList<RolDTO>( rolEntities.size() );
        for ( Role role : rolEntities ) {
            list.add( toDTO( role ) );
        }

        return list;
    }
}
