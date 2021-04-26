package org.codehaus.mojo.license.header.transformer;

/*
 * #%L
 * License Maven Plugin
 * %%
 * Copyright (C) 2008 - 2011 CodeLutin, Codehaus, Tony Chemit
 * %%
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Lesser Public License for more details.
 *
 * You should have received a copy of the GNU General Lesser Public
 * License along with this program.  If not, see
 * <http://www.gnu.org/licenses/lgpl-3.0.html>.
 * #L%
 */

import org.codehaus.plexus.component.annotations.Component;

/**
 * Implementation of {@link FileHeaderTransformer} for PHP format.
 *
 * @author tchemit dev@tchemit.fr
 * @author kmorin kmorin@codelutin.com
 * @since 1.0
 */
@Component( role = FileHeaderTransformer.class, hint = "php" )
public class PhpFileHeaderTransformer
    extends AbstractFileHeaderTransformer
{

    /**
     * Default constructor.
     */
    public PhpFileHeaderTransformer()
    {
        super( "php", "header transformer with php comment style", "<?php /*", " */ ?>", " * " );
    }

    /**
     * {@inheritDoc}
     */
    public String[] getDefaultAcceptedExtensions()
    {
        return new String[]{ "php" };
    }

}
