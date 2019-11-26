using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace HappyCommunity.Types
{
    public class User
    {
		public string UserName { get; set; }
        public string Name { get; set; }
        public int Points { get; set; }
        public string Address { get; set; }
        public int ZipCode { get; set; }
        public string City { get; set; }
        public int PhoneNumber { get; set; }
        public int CountryCode { get; set; }
    }
}
