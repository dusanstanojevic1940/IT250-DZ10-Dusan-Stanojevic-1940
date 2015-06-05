package com.dusanstanojevic.MetHotels.pages;

import org.apache.tapestry5.PersistenceConstants;
import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.hibernate.annotations.CommitAfter;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.hibernate.Session;

import com.dusanstanojevic.MetHotels.components.GenericEditor;
import com.dusanstanojevic.MetHotels.entities.Soba;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Start page of application MetHotels.
 */
public class Index extends GenericEditor<Soba> {}
