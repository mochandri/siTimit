<?php

defined('BASEPATH') or exit('No direct script access allowed');
require APPPATH . '/Libraries/REST_Controller.php';

use Restserver\Libraries\REST_Controller;

class Produk extends REST_Controller()
{

    function __construct($config = 'rest')
    {
        parent::__construct($config);
        $this->load->database();
    }

    function index_get()
    {
        $id = $this->get('id');
        if ($id == '') {
            $produk = $this->db->get('kategori_produk')->result();
        } else {
            $this->db->where('id', $id);
            $produk = $this->db->get('kategori_produk')->result();
        }
        $this->response(array("result" => $produk, 200));
    }
}
